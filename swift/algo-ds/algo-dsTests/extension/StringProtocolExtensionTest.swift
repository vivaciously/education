//
//  StringProtocolExtensionTest.swift
//  algo-ds
//
//  Created by Shin on 2021/11/13.
//

import Foundation
import XCTest

@testable import algo_ds

class StringProtocolExtensionTest: XCTestCase {
 
    
    override func setUp() {
        super.setUp()
    }
    
    override func tearDown() {
        super.tearDown()
    }
    
    func testSubscript() {
        let testString = "abcdefghijklmnopqrstuvwxyz"
        XCTAssert(testString[0] == "a")
        XCTAssert(testString[25] == "z")
        let start = Int(("a" as UnicodeScalar).value)
        for i in 0 ..< 26 {
            XCTAssert(testString[i] == Character(UnicodeScalar(start + i)!))
        }
        let anotherTestString = "あいうえお"
        XCTAssert(anotherTestString[0] == "あ")
        XCTAssert(anotherTestString[4] == "お")
    }
}
