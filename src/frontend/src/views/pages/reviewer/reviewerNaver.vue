<template>
  <Layout>
    <PageHeader :title="title" :items="items" class="pb-0" />
    <!-- searchBar -->
    <naverSearchbar/>

    <!-- dataList -->
    <naverDataList/>
  </Layout>
</template>

<script>
import Layout from "../../layouts/main";
import PageHeader from "@/components/page-header";
import naverSearchbar from '../../../components/reviewer/naverSearchbar.vue';
import naverDataList from '../../../components/reviewer/naverDataList.vue';


export default {
  page: {
    meta: [{ name: "reviewer naver" }]
  },
  components: { 
    Layout,
    PageHeader,
    naverSearchbar,
    naverDataList
  },
  data() {
    return {
      title: "리뷰어 목록 - 네이버",
      items: [
        {
          text: "리뷰어",
          href: "/reviewer/all"
        },
        {
          text: "네이버",
          active: true
        }
      ]
    };
  }
};
</script>
