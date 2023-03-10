export async function getOxfordTrails() {
	return getTrails("85ad791a-52cd-406f-a463-ea53fe277484")
}

async function getTrails(id) {
	return fetch(`http://localhost:8080/trails?id=${id}`);
}