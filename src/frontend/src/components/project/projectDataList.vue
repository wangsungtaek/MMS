<template>
<!-- 프로젝트 리스트 -->
<div class="row">
  <div class="col-lg-12">
    <div class="card">
      <div class="card-body">

        <div class="table-responsive">
          <b-table
            class="table-centered"
            :items="projects"
            :fields="projectHeader"
            responsive="sm"
            :per-page="perPage"
            :current-page="currentPage"
            :sort-by.sync="sortBy"
            :sort-desc.sync="sortDesc"
          >
            <!-- row number -->
            <template #cell(NO)="data">
              {{ data.index + 1 }}
            </template>

            <!-- 상태 값 -->
            <template v-slot:cell(STATE)="row">
              <div class="badge font-size-12 text-center"
                :class="{'badge-soft-danger': `${row.value}` === '시작전',
                         'badge-soft-success': `${row.value}` === '완료',
                         'badge-soft-warning': `${row.value}` === '진행중'}"
              >{{ row.value }}</div>
            </template>

            <!-- 버튼 그룹 -->
            <template v-slot:cell(ACTION)="row">
              <div class="row justify-content-end">
                <comButton label="수정" />
                <comButton label="삭제" color="danger" icon="mdi-trash-can" />
                <comButton label="신청서" color="secondary" icon="mdi-file-document" @buttonON="moveSignupForm(row)" />
              </div>
            </template>

          </b-table>          
        </div>
        <!-- end of Table -->

        <!-- 페이지 -->
        <div class="row">
          <div class="col">
            <div class="dataTables_paginate paging_simple_numbers float-right">
              <ul class="pagination pagination-rounded mb-0">
                <!-- pagination -->
                <b-pagination v-model="currentPage" :total-rows="rows" :per-page="perPage"></b-pagination>
              </ul>
            </div>
          </div>
        </div>
        
      </div>
    </div>
  </div>
</div>

</template>
<script>
import { projectComputed, projectMethods } from "@/state/helpers";
import comButton from '../common/comButton.vue';

export default {
  components: {
    comButton
  },
  created() {
    this.FETCH_PROJECT();
  },
  data() {
    return {
      // 프로젝트 그리드 해더
      projectHeader: [
        { key: "NO", label: "순번", },
        { key: "PROJECT_NM", label: "프로젝트명" },
        { key: "START_DT", sortable: true, label: "시작 날짜" },
        { key: "END_DT", sortable: true, label: "종료 날짜" },
        { key: "STATE", sortable: true, label: "상태" },
        { key: "ACTION", sortable: false, label: "" }
      ],
      
      currentPage: 1,
      perPage: 10,
      sortBy: "no",
      sortDesc: false,  
    };
  },
  computed: {
    ...projectComputed,
    rows() {
      return this.projects.length;
    }
  },
  methods: {
    ...projectMethods,
    moveSignupForm(row) {
      console.log(row.item);
      this.$router.push({
        name: 'signupForm',
        params: row.item
      })
    }
  }
};
</script>