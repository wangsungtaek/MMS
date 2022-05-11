<script>
import Layout from "../../layouts/main";
import PageHeader from "@/components/page-header";

export default {
  page: {
    meta: [{ name: "search naver" }]
  },
  components: { Layout, PageHeader },
  data() {
    return {
      title: "리뷰어 발굴 - 네이버",
      items: [
        {
          text: "리뷰어 발굴",
          href: "/"
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

<template>
  <Layout>
    <PageHeader :title="title" :items="items" />
  </Layout>
</template>