import { defineConfig } from "vite";
import react from "@vitejs/plugin-react";

// https://vite.dev/config/
export default defineConfig({
  plugins: [react()],
  define: {
    // Make sure environment variables are available in production
    "import.meta.env.VITE_API_BASE_URL": JSON.stringify(
      process.env.VITE_API_BASE_URL || "https://exampilot-70o5.onrender.com"
    ),
  },
  server: {
    // For development
    port: 5173,
  },
});
