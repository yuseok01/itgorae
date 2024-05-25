import { ref, computed } from 'vue';
import { defineStore } from 'pinia';
import router from '@/router';
import axios from 'axios';

const REST_USER_API = `http://localhost:8080/user`;

const getUserFromSession = () => {
    const userString = sessionStorage.getItem('user');
    return userString
        ? JSON.parse(userString)
        : {
              userId: '',
              teamId: '',
              email: '',
              userName: '',
              teamName: '',
              nickName: '',
              position: '',
              userGoals: '',
              userAssists: '',
              userImage: '',
              userRank: '',
          };
};

export const useUserStore = defineStore('user', () => {
    const user = ref(getUserFromSession());
    const Authenticated = ref(!!sessionStorage.getItem('access-token'));

    // console.log(Authenticated.value);

    const userLogin = (email, password) => {
        // 초기화
        axios
            .post(`${REST_USER_API}/login`, {
                email: email,
                password: password,
            })
            .then((res) => {
                // console.log(res);
                alert(res.data['userName'] + '님 환영합니다');
                sessionStorage.setItem('access-token', res.data['accessToken']);
                user.value.userId = res.data.userId;
                user.value.teamId = res.data.teamId;
                user.value.email = res.data.email;
                user.value.userName = res.data.userName;
                user.value.teamName = res.data.teamName;
                user.value.nickName = res.data.nickName;
                user.value.position = res.data.position;
                user.value.userGoals = res.data.userGoals;
                user.value.userAssists = res.data.userAssists;
                user.value.userImage = res.data.userImage;
                user.value.userRank = res.data.userRank;
                sessionStorage.setItem('user', JSON.stringify(user.value));
                // console.log(id);
            })
            .catch((err) => {
                alert('아이디 또는 비밀번호가 틀렸습니다');
                alert(err);
                // alert(res);
            })
            .finally(() => {});
    };

    const userLogout = () => {
        sessionStorage.clear();
        Authenticated.value = !Authenticated.value;
        console.log('로그아웃!');
        console.log(Authenticated.value);
    };

    return {
        Authenticated,
        userLogin,
        userLogout,
    };
});
