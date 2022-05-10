<script>
import { layoutComputed } from "@/state/helpers";
import Horizontal from "./horizontal";

export default {
  components: { Horizontal },
  data() {
    return {};
  },
  computed: {
    ...layoutComputed,
  },
  methods: {}
};
</script>

<template>
  <div>
  
    <Horizontal v-if="layoutType === 'horizontal'" :layout="layoutType">
      <slot />
    </Horizontal>
  </div>
</template>
