package com.example.turistguide;

    @Service
    public class WelcomeService {

        // Stub implementering
        private WelcomeRepository repository;

        public WelcomeService() {
            repository = new WelcomeRepository();
        }

        public List<Message> getWelcomeMessages()  {
            return repository.getWelcomeMessages();
        }

        public Message getWelcomeMessage(int id)  {
            return repository.getWelcomeMessage(id);
        }

        public Message postWelcomeMessage(Message message) {
            Message returnMessage = repository.addMessage(message);
            // her kunne server tilføje eksytra attributter, f.eks dato for oprettelse
            return returnMessage;
        }

        public Message putWelcomeMessage(Message message) {
            Message returnMessage = repository.changeMessage(message);
            return returnMessage;
        }

        public Message deleteWelcomeMessage(Message message) {
            Message returnMessage = repository.deleteMessage(message);
            if (returnMessage != null)
                return returnMessage;
            else return new Message("Ikke fundet");
        }

    }

}
