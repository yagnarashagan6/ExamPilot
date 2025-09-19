// API Configuration
const API_BASE_URL =
  import.meta.env.VITE_API_BASE_URL || "https://exampilot-70o5.onrender.com";

// Debug logging for environment variables
console.log("Environment mode:", import.meta.env.MODE);
console.log("VITE_API_BASE_URL:", import.meta.env.VITE_API_BASE_URL);
console.log("Final API_BASE_URL:", API_BASE_URL);

export { API_BASE_URL };
