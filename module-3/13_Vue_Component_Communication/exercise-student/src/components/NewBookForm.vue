<template>
<form class="new-book-form" v-on:submit.prevent="handleSave">
    <p> Enter a new book: </p>
    
    <label for="title">Title:</label>
    <input class="title-input" type="text" v-model="newBook.title" />
   
    <label for="author">Author:</label>
    <input class="author-input" type="text" v-model="newBook.author" />
    
    <label for="isbn">ISBN:</label>
    <input class="isbn-input" type="number" v-model="newBook.isbn" />
    
    <input type="submit" class="submit" value="Save">
</form>
  
</template>

<script>
export default {
    data() {
        return {
            newBook: {
                title: '',
                author: '',
                read: false,
                isbn: ''
            }
        }
    },
    methods: {
        handleSave(){
            let bookToAdd = this.newBook;
            this.$store.commit('ADD_BOOK', bookToAdd);
            //clear form for next addition and prevent odd form bugs
            this.newBook = {
                title: '',
                author: '',
                read: false,
                isbn: ''
            }
        }
    }
}
</script>

<style>

</style>