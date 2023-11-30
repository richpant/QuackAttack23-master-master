package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;


@TeleOp(name = "Testing Code")
public class Testing_Code extends OpMode {
    private DcMotor rightFront;
    private DcMotor rightRear;
    private DcMotor leftFront;
    private DcMotor leftRear;
    private DcMotor intake;
    //private DcMotor liftL;
    //private DcMotor liftR;
    private DcMotor arm;
    //private Servo clawL;
    //private Servo clawR;
    //private CRServo arm1;
    //private CRServo arm2;


    @Override
    public void init() {
        leftFront = hardwareMap.get(DcMotor.class, "leftFront");
        leftRear = hardwareMap.get(DcMotor.class, "leftRear");
        rightFront = hardwareMap.get(DcMotor.class, "rightFront");
        rightRear = hardwareMap.get(DcMotor.class, "rightRear");
        intake = hardwareMap.get(DcMotor.class, "intake");
        //liftL = hardwareMap.get(DcMotor.class, "liftL");
        //liftR = hardwareMap.get(DcMotor.class, "liftR");
        arm = hardwareMap.get(DcMotor.class, "arm");
        //clawL = hardwareMap.get(Servo.class, "clawL");
        //clawR = hardwareMap.get(Servo.class, "clawR");
        //arm1 = hardwareMap.get(CRServo.class, "arm1");
        //arm2 = hardwareMap.get(CRServo.class, "arm2");

        leftFront.setDirection(DcMotorSimple.Direction.FORWARD);
        leftRear.setDirection(DcMotorSimple.Direction.FORWARD);
        rightFront.setDirection(DcMotorSimple.Direction.REVERSE);
        rightRear.setDirection(DcMotorSimple.Direction.REVERSE);
        intake.setDirection(DcMotorSimple.Direction.FORWARD);
        //liftL.setDirection(DcMotorSimple.Direction.FORWARD);
        //liftR.setDirection(DcMotorSimple.Direction.REVERSE);
        arm.setDirection(DcMotorSimple.Direction.FORWARD);

        //clawL.setPosition(.5);
        //clawR.setPosition(.5);

        telemetry.addData("Say", "Hello Driver");
    }

    @Override
    public void loop() {

        double y = (1.4142135624 * gamepad1.left_stick_y) /2;
        double x = (1.4142135624 * gamepad1.left_stick_x) /2;
        double s = gamepad1.right_stick_x;

        leftFront.setPower(y - x - s);
        leftRear.setPower(y + x - s);
        rightFront.setPower(y + x + s);
        rightRear.setPower(y - x + s);

        if (gamepad1.left_bumper) {
            intake.setPower(1);
        } else if (gamepad1.right_bumper) {
            intake.setPower(-1);
        } else {
            intake.setPower(0);
        }
        /*
        if (gamepad1.dpad_up) {
            liftL.setPower(.6);
            liftR.setPower(.6);
        } else if (gamepad1.dpad_down) {
            liftL.setPower(-.6);
            liftR.setPower(-.6);
        } else {
            liftL.setPower(0);
            liftR.setPower(0);
        }
        */
        if (gamepad1.a) {
            arm.setPower(1);
        } else if(gamepad1.b) {
            arm.setPower(-1);
        } else {
            arm.setPower(0);
        }
        /*
        if (gamepad1.b) {
            clawL.setPosition(.45);
            clawR.setPosition(.55);
        } else {
            clawL.setPosition(.5);
            clawR.setPosition(.5);
        }

        if (gamepad1.x) {
            arm1.setPower(.1);
            arm2.setPower(-.1);
        } else if (gamepad1.y) {
            arm1.setPower(-.1);
            arm2.setPower(.1);
        } else if (gamepad1.dpad_left) {
            arm1.setPower(.1);
            arm2.setPower(0);
        } else if (gamepad1.dpad_right) {
            arm1.setPower(-.1);
            arm2.setPower(0);
        } else if (gamepad1.left_bumper) {
            arm1.setPower(0);
            arm2.setPower(.1);
        } else if (gamepad1.right_bumper) {
            arm1.setPower(0);
            arm2.setPower(-.1);
        }else {
            arm1.setPower(0);
            arm2.setPower(0);
        }
         */
    }
}