<template>
<div class="form-group">

  <!-- input -->
  <div class="row align-items-center">
    <div class="col-lg-4 text-right" v-if="isGridSystem">
      <label class="m-0">{{ title }} :</label>
    </div>
    <div :class="`col-lg-${isGridSystem? 8 : 12}`">
    <input 
      v-if="type == 'text' || type == 'number' || type == 'email'"
      class="form-control"
      v-model="value"
      :disabled="disable"
      :type="type"
      :placeholder="title"
    />

    <!-- textarea -->
    <textarea
      v-if="type == 'textarea'"
      class="form-control"
      v-model="value"
      :disabled="disable"
      rows="3"
      :placeholder="title"
    />

    <!-- select -->
    <b-form-select 
      v-if="type == 'select'"
      v-model="value"
      :disabled="disable"
      :options="items"
    />
    </div>
  </div>
</div>
</template>

<script>
export default {
  props: {
    title: {
      type: String,
      default: '',
    },
    type: {
      type: String,
      default: 'text'
    },
    items: {
      type: Array,
      default: null
    },
    disable: {
      type: Boolean,
      default: false
    },
    isGridSystem: {
      type: Boolean,
      default: false
    }
  },
  computed: {
    value: {
      get() {
        return this.$attrs.value;
      },
      set(newValue) {
        this.onDataChanged(newValue);
      },
    },
  },
  methods: {
    onDataChanged(value) {
      this.$emit('input', value)
    }
  }
}
</script>

<style>

</style>