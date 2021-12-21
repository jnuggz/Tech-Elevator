<template>
  <div class="reviews">
      <review-display 
        v-for="currentReview in filteredReviews"
        v-bind:key="currentReview.id"
        v-bind:review="currentReview"
      />
  </div>
</template>

<script>
import ReviewDisplay from './ReviewDisplay'

export default {
    name: 'review-list',
    components: {
        ReviewDisplay
    },
    computed: {
        filteredReviews() {
            const reviewFilter = this.$store.state.filter;
            const reviews = this.$store.state.reviews;
            return reviews.filter( review => {
                return reviewFilter === 0 ? true : this.filter === review.rating;
            });
        },
    }
}
</script>

<style>

</style>