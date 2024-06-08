interface Config {
  [key: string]: string;
  auth: "session" | "token";
}

// Session auth needs to use the same origin anyway 192.168.1.133
/*
export const config: Config = {
  apiUrl: "http://localhost:8080/api",
  contentUrl: "http://localhost:8080/api/v3/content",
  authUrl: "http://localhost:8080/api/v3/auth",
  auth: "token",
  socketUrl: "//localhost:8080/chat",
};

export const config: Config = {
  apiUrl: "http://192.168.1.133:8080/api",
  contentUrl: "http://192.168.1.133:8080/api/v3/content",
  authUrl: "http://192.168.1.133:8080/api/v3/auth",
  auth: "token",
  socketUrl: "//192.168.1.133:8080/chat",
};
*/
export const config: Config = {
  apiUrl: "http://localhost:8080/api",
  contentUrl: "http://localhost:8080/api/v3/content",
  authUrl: "http://localhost:8080/api/v3/auth",
  auth: "token",
  socketUrl: "//localhost:8080/chat",
};
