<template>
    <div class="well">
        <span class="amount" v-on:click="updateFilter = 1">{{ numberOfReviews }}</span>
        {{ rating }} Star Review{{ numberOfOneStarReviews === 1 ? '' : 's' }}
    </div>
</template>

<script>
export default {
    name: 'star-summary',
    props: ['rating'],
    methods: {
        updateFilter() {
            this.$store.commit('UPDATE_FILTER', parseInt(this.rating));
        }
    },
    computed: {
        numberOfReviews() {
            const reviews = this.$store.state.reviews;
           return reviews.reduce( (currentCount, review) => {
                return currentCount + (review.rating == this.rating);
            }, 0);
        },
    }
}
</script>

<style>

</style>