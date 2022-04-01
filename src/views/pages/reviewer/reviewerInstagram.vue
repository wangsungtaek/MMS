<script>
import Layout from "../../layouts/main";
import PageHeader from "@/components/page-header";

export default {
  page: {
    meta: [{ name: "reviewer instagram" }]
  },
  components: { Layout, PageHeader },
  data() {
    return {
      title: "리뷰어 목록 - 인스타그램",
      items: [
        {
          text: "리뷰어",
          href: "/"
        },
        {
          text: "인스타그램",
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