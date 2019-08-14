# ReccurentMessages
A spigot plugins for sending messages every x minutes

## How to use the config : 

The config is a classic YAML list. To use color codes, you must replace the usual '§' character by '&', and must have the string into quotation marks.

Here are a few example for 1, 2 or 4 messages : 

```yaml
# Configuration for the Reccurent Messages plugin
# List of all messages and timings
Messages:
- ==: me.EtienneDx.ReccurentMessages.Message
  message: '&bThis message will be sent every 5 minutes in aqua!'
  intervalInMinutes: 5
```

```yaml
# Configuration for the Reccurent Messages plugin
# List of all messages and timings
Messages:
- ==: me.EtienneDx.ReccurentMessages.Message
  message: '&bHello, World!'
  intervalInMinutes: 5
- ==: me.EtienneDx.ReccurentMessages.Message
  message: '&cAnother message'
  intervalInMinutes: 10
```

```yaml
# Configuration for the Reccurent Messages plugin
# List of all messages and timings
Messages:
- ==: me.EtienneDx.ReccurentMessages.Message
  message: This message have no color, it doesn't require quotation marks
  intervalInMinutes: 5
- ==: me.EtienneDx.ReccurentMessages.Message
  message: '&cAnother message'
  intervalInMinutes: 10
- ==: me.EtienneDx.ReccurentMessages.Message
  message: '&6This message is in gold!'
  intervalInMinutes: 5
- ==: me.EtienneDx.ReccurentMessages.Message
  message: '&lThis one is in bold, and sent every hour'
  intervalInMinutes: 60
```
