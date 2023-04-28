let review = document.getElementById("rateReview");

export const onSubmit = async (e) => {
  /**
   * Prevent the default browser behaviour of submitting
   * the form so that you can handle this instead.
   */
  e.preventDefault();
  console.log(e);

  /**
   * Get the element attached to the event handler.
   */
  let form = e.target;

  const token = "eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICIwNDA5SG5PRXFwdk1MM0QxY2RrNGdqSmhzUThYa3I0dGFWeHVMLUZpa3hjIn0.eyJleHAiOjE2ODI3MTY1MTcsImlhdCI6MTY4MjcxNjIxNywiYXV0aF90aW1lIjoxNjgyNzE2MjE1LCJqdGkiOiI1M2Q0ODVkMS0wMzU3LTRiMGItYTYwOC1jMzNjMWI3YjI4OGIiLCJpc3MiOiJodHRwOi8vY2VjbG54MDEuY2VjLm1pYW1pb2guZWR1OjgwODEvcmVhbG1zL0hpa2luZyIsImF1ZCI6ImFjY291bnQiLCJzdWIiOiIxMDIxOWY0OS05NTNhLTQzMDAtOThiOC0xNjk5YjQ5ZDE5MDYiLCJ0eXAiOiJCZWFyZXIiLCJhenAiOiJoaWtpbmctcHVibGljIiwibm9uY2UiOiJmMGJhN2M4MC01ZmM0LTRjNDEtYjY0NS0yZTIwYzY1MTdlOGMiLCJzZXNzaW9uX3N0YXRlIjoiZjg2MjFjODEtYWQ4Ni00MWZkLTg0Y2YtZWVlZjUzYzI2M2Y5IiwiYWNyIjoiMSIsImFsbG93ZWQtb3JpZ2lucyI6WyJodHRwOi8vMTcyLjI1LjI1Mi42NDozMDAwIiwiaHR0cDovL2xvY2FsaG9zdDozMDAxIl0sInJlYWxtX2FjY2VzcyI6eyJyb2xlcyI6WyJkZWZhdWx0LXJvbGVzLWhpa2luZyIsIm9mZmxpbmVfYWNjZXNzIiwidW1hX2F1dGhvcml6YXRpb24iXX0sInJlc291cmNlX2FjY2VzcyI6eyJhY2NvdW50Ijp7InJvbGVzIjpbIm1hbmFnZS1hY2NvdW50IiwibWFuYWdlLWFjY291bnQtbGlua3MiLCJ2aWV3LXByb2ZpbGUiXX19LCJzY29wZSI6Im9wZW5pZCBwaG9uZSBwcm9maWxlIGFkZHJlc3MgZW1haWwiLCJzaWQiOiJmODYyMWM4MS1hZDg2LTQxZmQtODRjZi1lZWVmNTNjMjYzZjkiLCJlbWFpbF92ZXJpZmllZCI6ZmFsc2UsImFkZHJlc3MiOnt9LCJuYW1lIjoiU2FtIEhpZWtlbiIsInByZWZlcnJlZF91c2VybmFtZSI6InNhbS5oaWVrZW5AZ21haWwuY29tIiwiZ2l2ZW5fbmFtZSI6IlNhbSIsImZhbWlseV9uYW1lIjoiSGlla2VuIiwiZW1haWwiOiJzYW0uaGlla2VuQGdtYWlsLmNvbSJ9.W4Qm3y2XSPZV3x9baNpwkTXiV5tU368rgNImPK9IBU5ZHvBCWJlPSS3YniseFVqdI9wrEVuICsXLg3_NEa3kn4Aj53XGsfItJ4FHQnyz_OD_O4A70j3I-roXLOpb_BMtgKCMyhu_BbRB1iwIawKo0hib73Yt0NmBSs0mVAT1VZBM0T4Sod1VdFX5_HtQ7Yoz7dRxeUQ0QVlbqDjiyehs9-mtlC7AHwiBJ2Gk8rwHF5wKf8wCb7L6oT1NxQGHLN-dGCKUbpt7qcni8-ghlNTLwwhGMoYFC-47bOObdN2EF_sgBAg0e5av0hY-tOz8Ll9K77g8Y8wVXZdXzJSaNT5Q7g"
  try {
    /**
     * Takes all the form fields and make the field values
     * available through a `FormData` instance.
     */

    /**
     * The `postFormFieldsAsJson()` function in the next step.
     */
    let responseData = await postFormFieldsAsJson(form, token);

    //Destructure the response data
    let { serverDataResponse } = responseData;

    //Display the response data in the console (for debugging)
    console.log(serverDataResponse);
  } catch (error) {
    //If an error occurs display it in the console (for debugging)
    console.error(error);
  }
};

/**
 * Helper function to POST data as JSON with Fetch.
 */
async function postFormFieldsAsJson(form, accessToken) {
  const id = form.trailName.value;
  const title = form.title.value;
  const rating = parseInt(form.rate.value);

  console.log(rating);

  const body = { trailID: id, stars: rating, body: null, title: title };

  //Set the fetch options (headers, body)
  let fetchOptions = {
    //HTTP method set to POST.
    method: "POST",
    //Set the headers that specify you're sending a JSON body request and accepting JSON response
    headers: {"Authorization": `Bearer ${accessToken}`, "Content-Type": "application/json"},
    // POST request body as JSON string.
    body: JSON.stringify(body)
  };

console.log(body)
  //Get the response body as JSON.
  //If the response was not OK, throw an error.
  let res = await fetch("http://ceclnx01.cec.miamioh.edu:8085/reviews", fetchOptions);

  //If the response is not ok throw an error (for debugging)
  if (!res.ok) {
    let error = await res.text();
    throw new Error(error);
  }
  //If the response was OK, return the response body.
  return res.json();
}