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
    let id = ''
    if(param) {
      id = param.PROJECT_ID
      
    }
    const url = `/api/project/${id}`
    const response = await axios.get(url, { params: param})
    commit("SET_PROJECTS", response.data);
  },
  async CREATE_PROJECT({ commit }, param) {
    console.log(commit)
    const response = await axios.post('/api/project', param)
    return response.data    
  },
};
