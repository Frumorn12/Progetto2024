

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


function checkEmailValidity(email) {
  return email.includes('@');
}
