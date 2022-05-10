<script>
import Layout from "../../layouts/main";
import PageHeader from "@/components/page-header";

export default {
  page: {
    meta: [{ name: "reviewer facebook" }]
  },
  components: { Layout, PageHeader },
  data() {
    return {
      title: "리뷰어 목록 - 페이스북",
      items: [
        {
          text: "리뷰어",
          href: "/"
        },
        {
          text: "페이스북",
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