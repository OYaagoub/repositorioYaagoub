interface Config {
  [key: string]: string;
  auth: "session" | "token";
}

// Session auth needs to use the same origin anyway
export const config: Config = {
  apiUrl: "http://localhost:8080/api",
  contentUrl: "http://localhost:8080/api/v3/content",
  authUrl: "http://localhost:8080/api/v3/auth",
  auth: "token",
};

