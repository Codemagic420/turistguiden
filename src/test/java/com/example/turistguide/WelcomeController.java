package com.example.turistguide;

@Controller
    @RequestMapping(path = "kea")       //localhost:8080/kea
    public class WelcomeController {


        private WelcomeService welcomeService;


        public WelcomeController() {
            this.welcomeService = new WelcomeService();
        }




        @GetMapping(path = "velkommen")     //localhost:8080/kea/velkommen
        public ResponseEntity<List<Message>> getMessages() {
            List messageList = welcomeService.getWelcomeMessages();
            return new ResponseEntity<List<Message>>(messageList, HttpStatus.OK);
        }


        @GetMapping(path = "velkommen/{id}")    //localhost:8080/kea/velkommen/1
        public ResponseEntity<String> getMessage(@PathVariable int id) {
//        Message message = welcomeService.getWelcomeMessage(id);
//        return new ResponseEntity<Message>(message, HttpStatus.OK);


            Message message = welcomeService.getWelcomeMessage(id);
            HttpHeaders responseHeaders = new HttpHeaders();
            responseHeaders.set("Content-Type","text/html");


            return new ResponseEntity<String>(
                    "<html><body><h1>" +
                            message.getMessage() +
                            "</h1></body></html>"
                    ,responseHeaders, HttpStatus.OK);
        }




        @PostMapping(path = "velkommen/opret")      //localhost:8080/kea/velkommen/opret
        public ResponseEntity<Message> postMessage(@RequestBody Message message) {
            Message returnMessage = welcomeService.postWelcomeMessage(message);
            return new ResponseEntity<Message>(returnMessage, HttpStatus.OK);
        }


        @PutMapping(path = "velkommen/ret")     //localhost:8080/kea/velkommen/ret
        public ResponseEntity<Message> putMessage(@RequestBody Message message) {
            Message returnMessage = welcomeService.putWelcomeMessage(message);
            if (returnMessage!=null)
                return new ResponseEntity<Message>(returnMessage, HttpStatus.OK);
            else
                return new ResponseEntity<Message>(new Message(0, "Ikke fundet"), HttpStatus.NOT_FOUND);
        }
gi

        @DeleteMapping("velkommen/slet")
        public ResponseEntity<Message> deleteMessage(@RequestBody Message message) {
            Message returnMessage = welcomeService.deleteWelcomeMessage(message);
            return new ResponseEntity<Message>(returnMessage, HttpStatus.OK);
        }
    }
