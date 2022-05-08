<template>
  <Layout>
    <PageHeader :title="title" :items="items" class="pb-0" />
    <div class="row">
      <!-- 카테고리 리스트 -->
      <div class="col-lg-4">
        <b-list-group>
          <b-list-group-item v-for="category in categoryList" :key="category.categoryId">
            <div class="row">
              <div class="col-lg-2 list">
                {{category.categoryId}}
              </div>
              <div class="col-lg-8 list" id="category">
                {{category.categoryNm}}
              </div>
              <div class="col-lg-2 text-right">
                <b-button variant="danger" @click="deleteCategory(category.categoryId)" size="sm">
                  <i class="mdi font-size-15 mdi-trash-can"></i>
                </b-button>
              </div>
            </div>
          </b-list-group-item>
          
        </b-list-group>
      </div>
      <div class="col-lg-3">
        <div class="card">
          <div class="card-body">
            <h4 class="card-title mb-3">카테고리 등록</h4>
            <ComInput v-model="category.categoryId" title="키값"/>
            <ComInput v-model="category.categoryNm" title="카테고리명"/>
            <div class="text-right">
              <button class="btn btn-primary" @click="createCategory">
                카테고리 등록
              </button>
            </div>
          </div>
        </div>
      </div>
    </div>
  </Layout>
</template>

<script>
import Layout from "../../layouts/main";
import PageHeader from "@/components/page-header";
import ComInput from '../../../components/common/ComInput';
import { categoryComputed, categoryMethods } from '@/state/helpers'


export default {
  page: {
    meta: [{ name: "setting category" }]
  },
  components: { 
    Layout,
    PageHeader,
    ComInput
  },
  created() {
    this.FATCH_CATEGORY();
  },
  data() {
    return {
      title: "설정 - 카테고리",
      items: [
        {
          text: "설정",
        },
        {
          text: "카테고리",
          active: true
        }
      ],

      category: {
        key: '',
        value: '',
      }
    };
  },

  computed: {
    ...categoryComputed
  },

  methods: {
    ...categoryMethods,

    initForm() {
      this.category.categoryId = ''
      this.category.categoryNm = ''
    },

    // 카테고리 생성
    createCategory() {
      this.CREATE_CATEGORY(this.category).then(result => {
        if(result) {
          this.initForm()
          this.FATCH_CATEGORY();
        }
      })   
    },

    // 카테고리 삭제
    deleteCategory(categoryId) {
      this.DELETE_CATEGORY({categoryId: categoryId}).then(result => {
        if(result) {
          this.FATCH_CATEGORY();
        }
      })
    }
  }
};
</script>
<style scoped>
#category {
  color: red;
}
.list {
  line-height: 33px;
}
</style>
