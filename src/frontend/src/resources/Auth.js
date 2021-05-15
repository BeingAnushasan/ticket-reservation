import decode from "jwt-decode";
import axios from "axios";

export default{
// const REST_ENDPOINT = 'http://localhost:3000/'
    AUTH_TOKEN_KEY : "token",

    logoutUser() {
        this.clearAuthToken();
    },

    setAuthToken(token) {
        axios.defaults.headers.common["Authorization"] = `Bearer ${token}`;
        localStorage.setItem(this.AUTH_TOKEN_KEY, token);
    },

    getAuthToken() {
        return localStorage.getItem(this.AUTH_TOKEN_KEY);
    },

    clearAuthToken() {
        axios.defaults.headers.common["Authorization"] = "";
        localStorage.removeItem(this.AUTH_TOKEN_KEY);
    },

    isLoggedIn() {
        let authToken = this.getAuthToken();
        return !!authToken && !this.isTokenExpired(authToken);
    },

    getUserInfo() {
        if (this.isLoggedIn()) {
            return decode(this.getAuthToken());
        }
    },

    getTokenExpirationDate(encodedToken) {
        let token = decode(encodedToken);
        if (!token.exp) {
            return null;
        }

        let date = new Date(0);
        date.setUTCSeconds(token.exp);

        return date;
    },

    isTokenExpired(token) {
        let expirationDate = this.getTokenExpirationDate(token);
        return expirationDate < new Date();
    },
};