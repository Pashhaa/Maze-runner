
const TelegramBot = require('node-telegram-bot-api');

const token = '---';
const bot = new TelegramBot(token, {polling: true});




bot.onText(/toroman (.+)/, function  (msg,b){
  const tuserId = msg.from.id;
  const a = b[1]
  let roman = '';
  if (a < 999999 && a > 0){
  const numbers = {M:1000,CM:900,D:500,CD:400,C:100,XC:90,L:50,XL:40,X:10,IX:9,V:5,IV:4,I:1};
  for (let key in numbers){
    while (a >= numbers[key]){
      roman += key;
      a -= numbers[key];
    }
  }
  bot.sendMessage(userId, roman);
}
  else{
    bot.sendMessage(userId, 'Введите пожалуйста числа')
  }});



bot.onText(/start/, function(msg){
  const userId = msg.from.id;
  bot.sendMessage(userId, 'Привет! Чтобы увидеть полный список команд: /help ');
});
bot.onText(/help/, function(msg){
  const userId = msg.from.id;
  bot.sendMessage(userId,    'Команда"toroman"("toroman АРАБСКОЕ_ЧИСЛО") - переводит арабские числа в римские(до 5000)')
})
