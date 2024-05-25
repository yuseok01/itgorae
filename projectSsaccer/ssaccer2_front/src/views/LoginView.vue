<template>
    <div>
        <body class="text-center container py-4">
            <main class="form-signin">
                <h2>Login</h2>
                <form method="post" @submit.prevent="login">
                    <!-- <h1 class="h3 mb-3 fw-normal">로그인 페이지</h1> -->

                    <div class="form-floating">
                        <input
                            type="text"
                            class="form-control"
                            id="id"
                            placeholder="아이디 입력..."
                            v-model.trim="id"
                        />
                        <label for="id">아이디</label>
                    </div>
                    <div class="form-floating">
                        <input type="password" class="form-control" id="pwd" placeholder="Password" v-model.trim="pw" />
                        <label for="pwd">비밀번호</label>
                    </div>

                    <div class="checkbox mb-3">
                        <label> <input type="checkbox" value="remember-me" /> 아이디 저장 </label>
                    </div>
                    <button class="w-100 btn btn-lg btn-primary" type="submit">로그인</button>
                    <!-- <p class="mt-5 mb-3 text-muted">&copy; 2017–2021</p> -->
                </form>
            </main>
        </body>

        <!-- <input type="text" placeholder="ID입력" v-model.trim="id" />
        <input type="password" placeholder="PW입력" v-model.trim="pw" />
        <button @click="login">로그인</button> -->
    </div>
</template>

<script setup>
// Q. 로그인을 위한 화면을 완성해봅시다.
import { ref, computed } from 'vue';
import { useUserStore } from '@/stores/user';

const userStore = useUserStore();
// const Authenticated = computed(() => userStore.Authenticated);

const id = ref('');
const pw = ref('');

const login = async () => {
    await userStore.userLogin(id.value, pw.value);
    const isAuthenticated = computed(() => userStore.Authenticated);

    console.log(isAuthenticated);
    if (isAuthenticated) {
        console.log('로그인 성공!!');
        window.location.href = '/';
    } else {
        console.log('로그인 실패');
    }
};
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap');

html,
body {
    height: 100%;
}

body {
    display: flex;
    align-items: center;
    padding-top: 40px;
    padding-bottom: 10px;
    background: rgba(0, 0, 0, 0);
    font-size: 14px;
    font-family: 'Roboto', sans-serif;
}

h2 {
    font-size: 24px;
    color: #6a24fe;
    margin-bottom: 20px;
}

/* .form {
} */
.form-signin {
    background-color: #f5f5f5;
    width: 100%;
    max-width: 330px;
    padding: 15px;
    margin: auto;
}

.form-signin .checkbox {
    font-weight: 400;
}

.form-signin .form-floating:focus-within {
    z-index: 2;
}

.form-signin input[type='email'] {
    margin-bottom: -1px;
    border-bottom-right-radius: 0;
    border-bottom-left-radius: 0;
}

.form-signin input[type='password'] {
    margin-bottom: 10px;
    border-top-left-radius: 0;
    border-top-right-radius: 0;
}

.form-signin > input[type='submit'] {
    color: #fff;
    font-size: 16px;
    background-color: #6a24fe;
    margin-top: 20px;
}
</style>
