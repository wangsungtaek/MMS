<script>
import Layout from "../../layouts/main";
import PageHeader from "@/components/page-header";

export default {
  page: {
    meta: [{ name: "reviewer all" }]
  },
  components: { Layout, PageHeader },
  data() {
    return {
      title: "리뷰어 통합 검색",
      items: [
        {
          text: "리뷰어",
          href: "/"
        },
        {
          text: "리뷰어 통합 검색",
          active: true
        }
      ]
    };
  }
};
</script>

<template>
  <Layout>
    <PageHeader :title="title" :items="items" />
  </Layout>
</template>