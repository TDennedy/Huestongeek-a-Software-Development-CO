import Keycloak from "keycloak-js";

const keycloak = new Keycloak({
        url: "http://ceclnx01.cec.miamioh.edu:8081",
        realm: "Hiking",
        clientId: "hiking-public"
    });

let resolver;

export const kcinit = new Promise((resolve) => {
    resolver = resolve;
});

export const refresh = async (hard = false) => {
    // Just for safety, it can't hurt
    const kc = await kcinit;

    if (hard === true || kc.isTokenExpired())
       await kc.updateToken(-1);

    return kc.token;
};

export function initKeycloak() {
    return  keycloak.init({
                onLoad: "check-sso",
                silentCheckSsoRedirectUri: origin + "/silent-check-sso.html",
                pkceMethod: "S256",
                scope: "openid email address phone"
            }).then((kc) => resolver(keycloak));
}

export default keycloak;