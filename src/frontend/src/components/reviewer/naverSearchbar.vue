<template>
  <div class="row">
    <div class="col-lg-12">
      <div class="card">
        <div class="card-body align-middle" id="card">
          <div class="row">

            <!-- 중요도 -->
            <div class="col-lg-2">
              <ComInput v-model="searchForm.important" type="select" :items="importantCombo"/>
            </div>

            <!-- 카테고리 -->
            <div class="col-lg-2">
              <ComInput v-model="searchForm.category" type="select" :items="categoryCombo"/>
            </div>

            <div class="col-lg-3"></div>

            <!-- 검색 조건 -->
            <div class="col-lg-1">
              <ComInput v-model="searchForm.searchDiv" type="select" :items="searchDivCombo"/>
            </div>

            <!-- 검색어 -->
            <div class="col-lg-3">
              <ComInput v-model="searchForm.searchWord" :items="searchDivCombo" title="검색어를 입력하세요."/>
            </div>

            <div class="col-lg-1">
              <b-button variant="primary" @click="searchBloger">
                <i class="fas fa-search align-middle mr-2"></i>검색
              </b-button>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import ComInput from '../common/ComInput';
import { reviewerMethods, categoryComputed } from '@/state/helpers'

export default {
  components: {
    ComInput
  },
  data() {
    return {
    
      // 검색 조건
      searchForm: {
        important: '',
        category: '',
        searchDiv: '',
        searchWord: ''
      },

      // 중요도 콤보
      importantCombo: [
        {value: '', text: '* 중요도 선택'},
        {value: '0', text: '중요도-0'},
        {value: '1', text: '중요도-1'},
        {value: '2', text: '중요도-2'},
        {value: '3', text: '중요도-3'},
        {value: '4', text: '중요도-4'},
      ],

      // 검색조건 콤보
      searchDivCombo: [
        {value: '', text: '검색조건'},
        {value: 'name', text: '이름'},
        {value: 'remark', text: '비고'},
      ],

    };
  },
  computed: {
    ...categoryComputed
  },

  methods: {
    ...reviewerMethods,

    // 블로거 검색
    searchBloger() {
      this.FATCH_BLOGER(this.searchForm)
    }
  }
};
</script>
<style scoped>
#card {
  height: 80px;
}
</style>