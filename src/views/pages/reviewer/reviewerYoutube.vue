<script>
import Layout from "../../layouts/main";
import PageHeader from "@/components/page-header";

export default {
  page: {
    meta: [{ name: "reviewer youtube" }]
  },
  components: { Layout, PageHeader },
  data() {
    return {
      title: "리뷰어 목록 - 유튜브",
      items: [
        {
          text: "리뷰어",
          href: "/"
        },
        {
          text: "유뷰트",
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