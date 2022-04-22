import axios from "axios";

export const state = {
  projects: []
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
  async FETCH_PROJECT({ commit }, param) {
    console.log(param);
    const response = await axios.get('/api/project', { params: param})
    commit("SET_PROJECTS", response.data);
  }
};
