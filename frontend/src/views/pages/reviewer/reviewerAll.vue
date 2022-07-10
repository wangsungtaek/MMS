<template>
  <Layout>
    <PageHeader :title="title" :items="items" class="pb-0" />
    <!-- searchBar -->
    <reviewerSearchbar/>

    <!-- dataList -->
    <reviewerList/>
  </Layout>
</template>

<script>
import Layout from "../../layouts/main";
import PageHeader from "@/components/page-header";
import reviewerSearchbar from '../../../components/reviewer/reviewerSearchbar.vue';
import reviewerList from '../../../components/reviewer/reviewerList.vue';

export default {
  page: {
    meta: [{ name: "reviewer" }]
  },
  components: { 
    Layout,
    PageHeader,
    reviewerSearchbar,
    reviewerList
  },
  data() {
    return {
      title: "리뷰어 목록",
      items: [
        {
          text: "리뷰어",
          href: "/reviewer/all"
        },
        {
          text: "목록",
          active: true
        }
      ]
    };
  }
};
</script>
