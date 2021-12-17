export {};

declare global {
    interface Environment {
        apiUrl: string;
    }
    
    interface Window {
        env: Environment;
    }
}
  