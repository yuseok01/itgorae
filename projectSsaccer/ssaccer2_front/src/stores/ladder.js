import { ref } from "vue";
import { defineStore } from "pinia";
import axios from "axios";

const REST_LADDER_API = `http://localhost:8080/team`;

export const useLadderStore = defineStore("ladder", () => {
  const list = ref([]);
  const rankAll = ref([]);
  const rankSeoul = ref([]);
  const rankGyeongi = ref([]);
  const rankDaejeon = ref([]);
  const rankDaegu = ref([]);
  const rankGwangju = ref([]);
  const rankBusan = ref([]);
  const rankUlsan = ref([]);
  const userTeamName = ref("");

  const getTeamList = () => {
    // console.log()
    list.value = [];
    axios
      .get(`${REST_LADDER_API}/searchAll`)
      .then((res) => {
        console.log(res);

        for (let index = 1; index < res.data.length; index++) {
          list.value.push(res.data[index]);
        }
      })
      .catch((err) => {
        console.log(err);
      });
  };

  const getTeamById = (id) => {
    axios
      .get(`${REST_LADDER_API}/search/${id}`)
      .then((res) => {
        // console.log(res);
        userTeamName.value = res.data.teamName;
      })
      .catch((err) => {
        console.log(err);
      });
  };

  const setRankSeoul = () => {
    // 전체 순위 조회
    rankSeoul.value = [];
    axios
      .get(`${REST_LADDER_API}/rankSeoul`)
      .then((res) => {
        for (let index = 0; index < res.data.length; index++) {
          rankSeoul.value.push(res.data[index]);
          console.log(rankSeoul.value[index]);
        }
      })
      .catch((err) => {
        console.log(err);
      })
      .finally(() => {
        console.log("실행 완료");
      });
  };
  const setRankGyeongi = () => {
    // 전체 순위 조회
    rankGyeongi.value = [];
    axios
      .get(`${REST_LADDER_API}/rankGyeongi`)
      .then((res) => {
        for (let index = 0; index < res.data.length; index++) {
          rankGyeongi.value.push(res.data[index]);
          console.log(rankGyeongi.value[index]);
        }
      })
      .catch((err) => {
        console.log(err);
      })
      .finally(() => {
        console.log("실행 완료");
      });
  };
  const setRankDaejeon = () => {
    // 전체 순위 조회
    rankDaejeon.value = [];
    axios
      .get(`${REST_LADDER_API}/rankDaejeon`)
      .then((res) => {
        for (let index = 0; index < res.data.length; index++) {
          rankDaejeon.value.push(res.data[index]);
          console.log(rankDaejeon.value[index]);
        }
      })
      .catch((err) => {
        console.log(err);
      })
      .finally(() => {
        console.log("실행 완료");
      });
  };
  const setRankDaegu = () => {
    // 전체 순위 조회
    rankDaegu.value = [];
    axios
      .get(`${REST_LADDER_API}/rankDaegu`)
      .then((res) => {
        for (let index = 0; index < res.data.length; index++) {
          rankDaegu.value.push(res.data[index]);
          console.log(rankDaegu.value[index]);
        }
      })
      .catch((err) => {
        console.log(err);
      })
      .finally(() => {
        console.log("실행 완료");
      });
  };
  const setRankGwangju = () => {
    // 전체 순위 조회
    rankGwangju.value = [];
    axios
      .get(`${REST_LADDER_API}/rankGwangju`)
      .then((res) => {
        for (let index = 0; index < res.data.length; index++) {
          rankGwangju.value.push(res.data[index]);
          console.log(rankGwangju.value[index]);
        }
      })
      .catch((err) => {
        console.log(err);
      })
      .finally(() => {
        console.log("실행 완료");
      });
  };
  const setRankBusan = () => {
    // 전체 순위 조회
    rankBusan.value = [];
    axios
      .get(`${REST_LADDER_API}/rankBusan`)
      .then((res) => {
        for (let index = 0; index < res.data.length; index++) {
          rankBusan.value.push(res.data[index]);
          console.log(rankBusan.value[index]);
        }
      })
      .catch((err) => {
        console.log(err);
      })
      .finally(() => {
        console.log("실행 완료");
      });
  };
  const SetRankUlsan = () => {
    // 전체 순위 조회
    rankUlsan.value = [];
    axios
      .get(`${REST_LADDER_API}/rankUlsan`)
      .then((res) => {
        for (let index = 0; index < res.data.length; index++) {
          rankUlsan.value.push(res.data[index]);
          console.log(rankUlsan.value[index]);
        }
      })
      .catch((err) => {
        console.log(err);
      })
      .finally(() => {
        console.log("실행 완료");
      });
  };

  const setRankAll = () => {
    rankAll.value = [];
    axios
      .get(`${REST_LADDER_API}/rankAll`)
      .then((res) => {
        for (let index = 0; index < res.data.length; index++) {
          rankAll.value.push(res.data[index]);
          console.log(rankAll.value[index]);
        }
      })
      .catch((err) => {
        console.log(err);
      })
      .finally(() => {
        console.log("실행 완료");
      });
  };
  return {
    getTeamList,
    list,
    getTeamById,
    userTeamName,
    setRankAll,
    rankAll,
    setRankSeoul,
    rankSeoul,
    setRankGyeongi,
    rankGyeongi,
    setRankDaejeon,
    rankDaejeon,
    setRankDaegu,
    rankDaegu,
    setRankGwangju,
    rankGwangju,
    setRankBusan,
    rankBusan,
    SetRankUlsan,
    rankUlsan,
  };
});
