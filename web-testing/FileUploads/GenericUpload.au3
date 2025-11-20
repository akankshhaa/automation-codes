; Wait for upload popup (max 10 sec)
Local $abc = WinWait("[CLASS:#32770]", "", 10)
; ALT: WinWait("[CLASS:#32770]", "", 10)

; Focus on File Name textbox
ControlFocus($abc, "", "Edit1")
; ALT: ControlFocus("[CLASS:#32770]", "", "Edit1")

; Set file path in textbox
ControlSetText($abc, "", "Edit1", "G:\CLASS 2023\Demo\Jan_2024_Selenium\FileUploads\SampleFile.txt")
; ALT: ControlSetText($abc, "", "Edit1", $CmdLine[1])

; Small wait before clicking
Sleep(2000)

; Click Open button
ControlClick($abc, "", "Button1")
; ALT: ControlClick("[CLASS:#32770]", "", "Button1")
