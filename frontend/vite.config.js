import { defineConfig } from "vite";
import react from "@vitejs/plugin-react";

// https://vite.dev/config/
export default defineConfig({
  plugins: [react()],
  define: {
    // Explicitly define the API URL for production builds
    __API_BASE_URL__: JSON.stringify("https://exampilot-70o5.onrender.com"),
    // Also keep the environment variable approach
    "import.meta.env.VITE_API_BASE_URL": JSON.stringify(
      process.env.VITE_API_BASE_URL || "https://exampilot-70o5.onrender.com"
    ),
  },
  server: {
    // For development
    port: 5173,
  },
});
