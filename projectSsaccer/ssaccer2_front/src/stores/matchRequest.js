import { ref } from 'vue';
import { defineStore } from 'pinia';
import axios from 'axios';

const REST_MATCHREQUEST_API = `http://localhost:8080/matchRequest`;

export const useMatchRequestStore = defineStore('matchRequest', () => {
    const reqList = ref([]); // 매치 신청 발신 목록
    const resList = ref([]); // 매치 신청 수신 목록
    const matchRequestId = ref(0);

    const request = (from, to) => {
        // from : 보내는 팀, to : 받는 팀
        axios
            .post(`${REST_MATCHREQUEST_API}`, {
                teamIdFrom: from,
                teamIdTo: to,
            })
            .then((res) => {
                console.log(res);
            })
            .catch((err) => {
                console.log(err);
            });
    };

    const search = (from, to) => {
        axios
            .get(`${REST_MATCHREQUEST_API}`, {
                params: {
                    teamIdFrom: from,
                    teamIdTo: to,
                },
            })
            .then((res) => {
                matchRequestId.value = res.data.matchRequestId;
                console.log(matchRequestId.value);
                cancel(matchRequestId.value);
            })
            .catch((err) => {
                console.log(err);
            });
    };

    const cancel = (id) => {
        axios
            .delete(`${REST_MATCHREQUEST_API}/${id}`)
            .then((res) => {
                console.log('delete');
                console.log(res);
            })
            .catch((err) => {
                console.log(err);
            });
    };

    const setResList = (to) => {
        resList.value = [];
        axios
            .get(`${REST_MATCHREQUEST_API}/${to}`)
            .then((res) => {
                // console.log(res);

                for (let index = 0; index < res.data.length; index++) {
                    // console.log(res.data[index]);
                    resList.value.push(res.data[index]);
                }
                console.log(resList);
            })
            .catch((err) => {
                console.log(err);
            });
    };

    // const acceptMatch =

    return {
        request,
        search,
        cancel,
        matchRequestId,
        setResList,
        resList,
    };
    // const getMarketList = (key, word, orderBy, orderDir) => {
    //     console.log(key);
    //     console.log(orderBy);
    //     list.value = [];
    //     axios
    //         .get(`${REST_MARKET_API}/board`, {
    //             params: {
    //                 key: key,
    //                 word: word,
    //                 orderBy: orderBy,
    //                 orderDir: orderDir,
    //             },
    //         })
    //         .then((res) => {
    //             console.log(res);
    //             for (let index = 0; index < res.data.length; index++) {
    //                 // const element = array[index];
    //                 // console.log(res.data[index]);
    //                 list.value.push(res.data[index]);
    //             }

    //             // console.log(list.value);
    //         })
    //         .catch((res) => {
    //             console.log(res);
    //         });
    // };
});
