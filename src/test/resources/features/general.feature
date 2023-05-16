Feature: SPC Brasil General Functions


   @dealocatetDevices
  Scenario Outline: TS:["<TS>"] - [Dealocate Devices]  - "<Scenario>" - "<Description>"
    Given verify devices allocated and dealocate
    Examples:
      | TS      | Scenario      | Description             |
      | 001     | 001           | Dealocate Devices       |


  @rebootDevices
  Scenario Outline: TS:["<TS>"] - [Reboot Devices]  - "<Scenario>" - "<Description>"
    Given reboot devices "<device>"
    Examples:
      | TS      | Scenario      | Description              |device       |
      | 001     | 001           | Reboot Moto G4           |MotoG4       |
      | 001     | 001           | Reboot J5Prime           |J5Prime      |
      | 001     | 001           | Reboot GalaxyA7          |GalaxyA7     |
