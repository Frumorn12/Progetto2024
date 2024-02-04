 

function calculateStrength(password) {
  // Calcola la forza in base alla lunghezza della password
  const length = password.length;

  if (length < 8) {
    return 0; // Password troppo corta
  } else if (length < 10) {
    return 50; // Password moderatamente forte
  } else {
    return 100; // Password molto forte
  }
}


function onSignIn(googleUser) {
  var profile = googleUser.getBasicProfile();
  console.log('ID: ' + profile.getId()); // Do not send to your backend! Use an ID token instead.
  console.log('Name: ' + profile.getName());
  console.log('Image URL: ' + profile.getImageUrl());
  console.log('Email: ' + profile.getEmail()); // This is null if the 'email' scope is not present.
}
