<template>
    <div class="card">
        <div class="card-body">
            <!-- type : new면 new로 뿌리기 notice면 notice로뿌리기 -->
            <h6><span class="badge bg-secondary ">{{typeName}}</span></h6>
            <h5 class="card-title mt-2">{{title}}</h5>
            <p class="card-text">{{contents}}</p>
           
            <a href="#" class ="btn" :class ="isLikeClass ">좋아요</a>
        </div>
    </div>
</template>

<script>
   import { computed } from 'vue';
export default {
    // 프롭스 설정 
    // 스트링이고 default require vaildator
    //부모로 부터 받은 값이 트루면 유효성검사 
    props : {
        type:{
            type : String,
            default: 'news',
            validator: (value) => {
                return ['news', 'notice'].includes(value);
            },
        },
        title : {
            type : String,
            required : true,
        },
        contents: {
            type : String,
            required : true,
        },
        isLike: {
            type: Boolean,
            default : false
        }
    },
    setup(props) {
        console.log('props.title' , props.title);
        const isLikeClass = computed(() => props.isLike ? 'btn-danger' : 'btn-outline-danger')
        const typeName = computed(()=> props.type =='news' ? '뉴스' :'공지사항')
        return {isLikeClass,typeName}; 
    }

}
</script>

<style scoped></style>