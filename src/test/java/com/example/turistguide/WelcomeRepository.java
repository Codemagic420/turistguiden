package com.example.turistguide;

@Repository
public class WelcomeRepository {
    private List<Message> messages = new ArrayList<Message>(List.of(
            new Message(1, "Velkommen til Toristkontrolleren"),
            new Message(2, "Hjertelig velkommen til KEA"),
            new Message(3, "Vi ønsker dig velkommen til KEA"),
            new Message(4, "Vi ønsker hold C velkommen til KEA")

    ));

    public List<Message> getWelcomeMessages()  {
        return messages;
    }
    public Message getWelcomeMessage(int id)  {
        //TODO ret til at finde message index
        return messages.get(id);
    }

    public Message addMessage(Message message) {
        messages.add(message);
        // her kunne server tilføje ekstra attributter, f.eks dato for oprettelse
        // inden vi returnerer message
        return message;
    }

    public Message changeMessage(Message message) {
        //Overskriv eksisterende message

        // find message i messages
        int i=0;
        while (i < messages.size()) {
            if (message.getId() == messages.get(i).getId()) {
                messages.set(i, message);
                return message;
            }
            i++;
        }
        return null; // ikke fundet

    }

    public Message deleteMessage(Message message) {
        int foundIndex = -1;
        Message returnMessage = new Message("Ikke fundet");

        for (int i=0; i < messages.size(); i++) {
            if (message.getId() == messages.get(i).getId()) {
                foundIndex = i;
            }
        }
        if (foundIndex != -1) {
            returnMessage = messages.get(foundIndex);
            messages.remove(foundIndex);
        }

        return returnMessage;
    }
}

@Repository
public class WelcomeRepository {
    private List<Message> messages = new ArrayList<Message>(List.of(
            new Message(1, "Velkommen til KEA"),
            new Message(2, "Hjertelig velkommen til KEA"),
            new Message(3, "Vi ønsker dig velkommen til KEA"),
            new Message(4, "Vi ønsker hold C velkommen til KEA")

    ));

    public List<Message> getWelcomeMessages()  {
        return messages;
    }
    public Message getWelcomeMessage(int id)  {
        //TODO ret til at finde message index
        return messages.get(id);
    }

    public Message addMessage(Message message) {
        messages.add(message);
        // her kunne server tilføje ekstra attributter, f.eks dato for oprettelse
        // inden vi returnerer message
        return message;
    }

    public Message changeMessage(Message message) {
        //Overskriv eksisterende message

        // find message i messages
        int i=0;
        while (i < messages.size()) {
            if (message.getId() == messages.get(i).getId()) {
                messages.set(i, message);
                return message;
            }
            i++;
        }
        return null; // ikke fundet

    }

    public Message deleteMessage(Message message) {
        int foundIndex = -1;
        Message returnMessage = new Message("Ikke fundet");

        for (int i=0; i < messages.size(); i++) {
            if (message.getId() == messages.get(i).getId()) {
                foundIndex = i;
            }
        }
        if (foundIndex != -1) {
            returnMessage = messages.get(foundIndex);
            messages.remove(foundIndex);
        }

        return returnMessage;
    }
}

