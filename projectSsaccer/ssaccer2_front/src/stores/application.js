// 가입신청 스토어
import { ref } from 'vue';
import { defineStore } from 'pinia';
import router from '@/router';
import axios from 'axios';

const REST_MARKET_API = `http://localhost:8080/application`;

export const useApplicationStore = defineStore('application', () => {
    const list = ref([]); // 가입 신청 목록

    const getApplicationList = (id) => {
        list.value = [];
        axios
            .get(`${REST_MARKET_API}/team/${id}`)
            .then((res) => {
                console.log(res);
                for (let index = 0; index < res.data.length; index++) {
                    list.value.push(res.data[index]);
                }

                console.log(list.value);
            })
            .catch((res) => {
                console.log(res);
            });
    };

    const acceptApplication = (id) => {
        axios
            .put(`${REST_MARKET_API}/accept/${id}`)
            .then((res) => {
                console.log(res);
            })
            .catch((err) => {
                console.log(err);
            });
    };

    const rejectApplication = (id) => {
        axios
            .put(`${REST_MARKET_API}/reject/${id}`)
            .then((res) => {
                console.log(res);
            })
            .catch((err) => {
                console.log(err);
            });
    };

    return {
        getApplicationList,
        list,
        acceptApplication,
        rejectApplication,
    };
});
