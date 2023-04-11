<template>
    <div style="width: 100vw;height: 100vh;overflow: hidden;display:flex">
        <div style="flex: 1;background-color: dodgerblue">
            <el-image style="width: 100%;height: 100%" fit="cover"
                      src="https://ts1.cn.mm.bing.net/th/id/R-C.8d53df2d59b55efe59eaa4eb7187b359?rik=%2b9R9%2bT%2fHawXnMQ&riu=http%3a%2f%2fpic.qqbizhi.com%2fallimg%2fbbpic%2f73%2f973_6.jpg&ehk=zuyXbAtcpjXWL%2b%2bze3lwhVLddoeomp8AgaDtg7UVR5g%3d&risl=&pid=ImgRaw&r=0"/>
        </div>
        <div class="welcome-title">
            <div style="font-size: 30px;font-weight: bold">欢迎来到学习平台</div>
            <div style="margin-top: 10px">超越自己</div>
            <div style="margin-top: 5px">奥里给</div>
        </div>

        <div style="width: 400px;background-color: white; z-index: 1">
            <router-view v-slot="{ Component }">
                <transition name="el-fade-in-linear">
                    <component :is="Component"/>
                </transition>
            </router-view>


        </div>
    </div>
</template>

<script setup>

</script>

<style scoped>
.welcome-title{
    position: absolute;
    bottom: 30px;
    left: 30px;
    color:white;
    text-shadow: 0 0 10px black;
}
</style>