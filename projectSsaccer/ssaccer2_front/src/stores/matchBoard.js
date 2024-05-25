import { ref } from 'vue';
import { defineStore } from 'pinia';
import axios from 'axios';

const REST_MATCHBOARD_API = `http://localhost:8080/matchBoards`;

export const useMatchBoardStore = defineStore('matchBoards', () => {
    const latestMatch = ref([]);

    const create = (myTeamId, opposingTeamId) => {
        axios
            .post(`${REST_MATCHBOARD_API}`, {
                myTeamId: myTeamId,
                opposingTeamId: opposingTeamId,
            })
            .then((res) => {
                console.log(res);
            })
            .catch((err) => {
                console.log(err);
            });
    };

    const getLatest = (id) => {
        latestMatch.value = [];
        axios
            .get(`${REST_MATCHBOARD_API}/${id}`)
            .then((res) => {
                latestMatch.value = res.data; // res.data를 바로 배열로 할당
            })
            .catch((err) => {
                console.log(err);
            });
    };

    return {
        create,
        getLatest,
        latestMatch,
    };
});