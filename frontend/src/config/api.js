// API Configuration
// Hardcode production URL as default to ensure it works
const API_BASE_URL =
  import.meta.env.VITE_API_BASE_URL || "https://exampilot-70o5.onrender.com";

// Debug logging for environment variables
console.log("Environment mode:", import.meta.env.MODE);
console.log("VITE_API_BASE_URL from env:", import.meta.env.VITE_API_BASE_URL);
console.log("Final API_BASE_URL being used:", API_BASE_URL);
console.log("All environment variables:", import.meta.env);

export { API_BASE_URL };
