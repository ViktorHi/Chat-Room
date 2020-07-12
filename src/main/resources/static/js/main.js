
var messageApi = Vue.resource('/chat{/id}');

Vue.component('message-row', {
        props: ['messages'],
        template: '<div><i>id: {{ messages.id }} </i>text: {{ messages.text }} admin id: {{ messages.userId  }} time: {{messages.sendingTime}} </div>',
});

Vue.component('messages-list', {
    props: ['messages'],
    template:
        '<div>' +
        ' <message-form :messages="messages"></message-form>' +
        ' <message-row v-for="message in messages" :key="message.id" :messages="message" />' +
        '</div>',
    created: function () {
        messageApi.get()
            .then(result => result.json()
                .then(data => data.forEach(
                    mess => this.messages.push(mess)
                )))
    }
});

Vue.component('message-form',{
    data: function(){
      return{
          text: ''
      }
    },
    props: ['messages'],
    template:
        '<div>' +
            '<input type="text" placeholder="Write message" v-model="text"\>' +
            '<input type="button" value="save" v-on:click="save" \>' +
        '<div/>',
    methods: {
        save: function () {
            var message = {text: this.text};

            messageApi.save({}, message).then(result => result.json().then(data =>{
                this.messages.push(data);
                this.text = ''
            }))
        }
    },
} )
var app = new Vue({
    el: '#app',
    template: '<messages-list :messages="messages" />',
    data: {
        messages: [
        ]
    }
});