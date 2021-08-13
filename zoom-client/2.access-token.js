const axios = require('axios').default
const base64 = require('base-64')

async function generateAccessToken(authorizationCode) {
  const clientId = "nJd15hLCQj2o3ynXszpsDw"
  const clientSecret = "lwVNrTQPxcffVsJkjWE6r4SuMsKhLve1"

  const authorization = `Basic ${base64.encode(`${clientId}:${clientSecret}`)}`
  const result = await axios.post('https://zoom.us/oauth/token', null, {
    headers: {
      'Authorization': authorization,
      'Content-type': 'application/x-www-form-urlencoded'
    },
    params: {
      'grant_type': 'authorization_code',
      code: authorizationCode,
      redirect_uri: 'https://localhost:3000',
    }
  })

  return result.data.access_token
}

module.exports = generateAccessToken
