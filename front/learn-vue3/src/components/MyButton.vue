<template>
        <button class="btn btn-primary" type="button" v-bind="$attrs">My Button</button>
</template>

<script>
export default {
    inheritAttrs : false,
    setup(props, context) {

        return {}
    }
}
</script>

<style lang="scss" scoped></style>