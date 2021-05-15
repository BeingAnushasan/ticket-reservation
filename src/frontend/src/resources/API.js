import axios from "axios";
import store from "../store/index";
import cookie from 'vue-cookies';

export default {
    localLink: store.state.backend_URL,

    authenticate(AuthReq) {
        // this.auth = AuthReq;

        return axios.post(this.localLink + "/security/login", AuthReq, {
            headers: {
                "Content-Type": "application/json",
            },
        });
    },

    signUp(userAuthReq) {
        return axios.post(this.localLink + "/security/signup", userAuthReq, {
            headers: {
                "Content-Type": "application/json",
            },
        });
    },


    sayHello() {
        axios.get(this.localLink + "/hello", {
            headers: {
                Authorization: "Bearer " + JSON.parse(cookie.get(`token`)),
            },
        });
    },

    makeReservation(reservationReq) {
        return axios.post(this.localLink + "/api/v1/reserve",reservationReq, {
            headers: {
                Authorization: "Bearer " + JSON.parse(cookie.get(`token`)),
            },
        });
    },

    getAllMoviesFromMyDB() {
        return axios.get(this.localLink + "/movie", {
            headers: {
                Authorization: "Bearer " + JSON.parse(cookie.get(`token`)),
            },
        });
    },

    getMoviesFromMyDB(name, genre) {
        return axios.get(
            this.localLink + "/search?genre=" + genre + "&name=" + name,
            {
                headers: {
                    Authorization: "Bearer " + JSON.parse(cookie.get(`token`)),
                },
            }
        );
    },

    saveMovieInMyDB(movie) {
        axios.post(this.localLink + "/movie", movie, {
            headers: {
                "Content-Type": "application/json",
                Authorization: "Bearer " + JSON.parse(cookie.get(`token`)),
            },
        });
    },
};
