import { ref } from 'vue';
import { defineStore } from 'pinia';
import router from '@/router';
import axios from 'axios';

const REST_MARKET_API = `http://localhost:8080/teamRecruitment`;

export const useMarketStore = defineStore('market', () => {
    const list = ref([]);

    const getMarketList = (key, word, orderBy, orderDir) => {
        console.log(key);
        console.log(orderBy);
        list.value = [];
        axios
            .get(`${REST_MARKET_API}/board`, {
                params: {
                    key: key,
                    word: word,
                    orderBy: orderBy,
                    orderDir: orderDir,
                },
            })
            .then((res) => {
                console.log(res);
                for (let index = 0; index < res.data.length; index++) {
                    // const element = array[index];
                    // console.log(res.data[index]);
                    list.value.push(res.data[index]);
                }

                // console.log(list.value);
            })
            .catch((res) => {
                console.log(res);
            });
    };

    return {
        getMarketList,
        list,
    };
});
