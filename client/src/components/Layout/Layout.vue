<template>
    <div id="grid">

    </div>
</template>

<script>
export default {

}
</script>

<style scoped>
/* SL - Server List */
/* SN - Server Name */
/* CI - Channel Info */
/* CL - Channel List */
/* CD - Channel Data */
/* UL - User List */
/* UI - User Info */
#grid {
    display: grid;
    grid-template-columns: 71px 240px auto 240px ;
    grid-template-rows: 46px auto 52px;
    grid-template-areas:
    'SL SN CI CI'
    'SL CL CD UL'
    'SL UI CD UL';
    height: 100vh;

}
</style>
