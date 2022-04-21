import axios from "axios";

export const state = {
  projects: ['1', '2']
};

export const getters = {
  GET_PROJECTS(state) {
    return state.projects
  }
}

export const mutations = {
  SET_PROJECTS(state, projects) {
    state.projects = projects
  },
};

export const actions = {
  async FETCH_PROJECT({ commit }) {
    const response = await axios.get('/api/sample/findSampleInfo.do', 'get')
    console.log(response);
    commit("SET_PROJECTS", response);
  }
};
